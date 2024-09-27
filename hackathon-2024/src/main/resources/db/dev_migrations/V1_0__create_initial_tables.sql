create table if not exists "location"
(
    id bigserial not null constraint location_pk primary key,
    customer_sap text not null,
    "name" text not null,
    "path" text not null,
    "type" smallint not null default 0,
    parent_id bigint,
    created_by text,
    created_at timestamp with time zone default CURRENT_TIMESTAMP not null,
    updated_by text,
    updated_at timestamp with time zone not null,
    FOREIGN KEY (parent_id) references iomt_dm_di.location (id),
    CONSTRAINT location_type_validity CHECK("type" IN (0, 1, 2, 3)),
    CONSTRAINT location_customer_path_unique UNIQUE (customer_sap, path)
    );

create table if not exists device
(
    id uuid not null constraint device_pk primary key,
    serial_number varchar(50) not null,
    product_id varchar(50) not null,
    product_family varchar(50),
    product_type varchar(50),
    asset_id text,
    asset_label text,
    location_id bigint,
    availability_status smallint,
    related_link text,
    favorite boolean not null default false,
    organization text NOT NULL DEFAULT 'Care Unit A',
    customer_sap text not null,
    created_by text,
    created_at timestamp with time zone default CURRENT_TIMESTAMP not null,
    updated_by text,
    updated_at timestamp with time zone not null,
    foreign key (location_id) references "location" (id)
    );

create table if not exists "group"
(
    id bigserial not null constraint group_pk primary key,
    "name" text not null,
    subtitle text,
    customer_sap text not null,
    created_by text,
    created_at timestamp with time zone default CURRENT_TIMESTAMP not null,
    updated_by text,
    updated_at timestamp with time zone not null,
    CONSTRAINT customer_sap_name_unique UNIQUE (customer_sap, "name")
    );

create table if not exists device_group
(
    device_id uuid references device (id),
    group_id bigint references "group" (id),
    primary key (device_id, group_id),
    foreign key (device_id) REFERENCES iomt_dm_di.device (id)
    );

create table if not exists device_reported_activity
(
    device_id uuid not null constraint device_reported_activity_pk primary key,
    software_version text,
    operating_cycles text,
    working_hours text,
    manufacture text,
    clinical_use text,
    last_activity timestamp with time zone not null,
    origin_updated_at timestamp with time zone not null DEFAULT TIMESTAMP 'epoch',
    synced_at timestamp with time zone not null default now(),
    foreign key (device_id) references device (id)
    );

create table if not exists device_reported_interface
(
    device_id uuid not null constraint device_reported_interface_pk primary key,
    "name" text not null,
    address text,
    "type" smallint,
    speed text,
    physical_status text,
    last_connected timestamp with time zone not null,
    origin_updated_at timestamp with time zone not null DEFAULT TIMESTAMP 'epoch',
    synced_at timestamp with time zone not null default now(),
    foreign key (device_id) references device(id)
    );

CREATE OR replace VIEW iomt_dm_di.device_view AS
SELECT d.id AS id, d.customer_sap AS customer_sap, d.product_type AS product_name, d.serial_number,
       d.asset_id, d.asset_label, d.product_family AS category, d.organization,
       l."name" AS location, d.availability_status, COALESCE(d.favorite, false) as favorite, l.id as location_id
FROM iomt_dm_di.device AS d
         LEFT JOIN iomt_dm_di."location" AS l ON (l.id = d.location_id)
ORDER BY d.asset_label ASC;

CREATE INDEX IF NOT EXISTS device_customer_sap_idx ON device (customer_sap);
CREATE INDEX IF NOT EXISTS location_customer_sap_idx ON "location" (customer_sap);
CREATE INDEX IF NOT EXISTS group_customer_sap_group_name_idx ON "group" (customer_sap, "name");