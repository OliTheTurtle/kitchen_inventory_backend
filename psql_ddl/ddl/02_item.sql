create table "data"."item" (
    id bigserial primary key,
    name varchar not null,
    best_before_date date not null,
    ean_number integer null,
    location_id bigint null references "data"."location"(id) on delete set null
);