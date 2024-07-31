CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table audio (
  id                            BIGSERIAL primary key,
  description                   TEXT,
  file_size_bytes               bigint,
  bpm                           integer,
  name                          varchar(255),
  file_path                     varchar(255),
  file_format                   varchar(255),
  duration                      varchar(255)
);

create table category (
  id                            BIGSERIAL PRIMARY KEY,
  parent_id                     BIGSERIAL,
  name                          varchar(255) not null,
  constraint uq_category_name unique (name)
);

create table lifecycle_log (
  id                            BIGSERIAL PRIMARY KEY,
  details                       TEXT,
  log_time                      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  sheet_music_id                varchar(255),
  event                         varchar(8) not null,
  user_id                       varchar(255) not null,
  constraint ck_lifecycle_log_event check ( event in ('CREATE','UPDATE','ENABLE','APPROVE','DISPROVE','DISABLE'))
);

create table rating (
  id                            BIGSERIAL PRIMARY KEY,
  rate                          integer not null,
  sheet_music_id                varchar(255),
  user_id                       varchar(255)
);

create table sheet_music (
  tempo                         integer not null,
  description                   TEXT,
  page_count                    integer,
  average_rating                DECIMAL(8,2) not null default 0.00,
  rating_count                  bigint not null default 0,
  approved                      boolean default false not null,
  enabled                       boolean default false not null,
  extracted_text                TEXT,
  id                            varchar(255) unique default uuid_generate_v4(),
  title                         varchar(255) not null,
  sub_title                     varchar(255),
  lyricist                      varchar(255),
  composer                      varchar(255),
  arranger                      varchar(255),
  time_signature                varchar(255),
  file_path                      varchar(255),
  cover_image_path              varchar(255),
  uploaded_by_id                varchar(255) not null,
  constraint pk_sheet_music primary key (id)
);

create table sheet_music_key_signatures (
  sheet_music_id                varchar(255) not null,
  key_signature                 varchar(255) not null,
  constraint ck_sheet_music_key_signatures_key_signature check ( key_signature in ('C_MAJOR','G_MAJOR','D_MAJOR','A_MAJOR','E_MAJOR','B_MAJOR','F_SHARP_MAJOR','C_SHARP_MAJOR','A_FLAT_MAJOR','E_FLAT_MAJOR','B_FLAT_MAJOR','F_MAJOR','C_MINOR','G_MINOR','D_MINOR','A_MINOR','E_MINOR','B_MINOR','F_SHARP_MINOR','C_SHARP_MINOR','A_FLAT_MINOR','E_FLAT_MINOR','B_FLAT_MINOR','F_MINOR'))
);

create table sheet_music_categories (
  category_id                   BIGSERIAL not null,
  sheet_music_id                varchar(255) not null,
  constraint pk_sheet_music_categories primary key (sheet_music_id,category_id)
);

create table sheet_music_audios (
  audio_id                      BIGSERIAL not null,
  sheet_music_id                varchar(255) not null,
  constraint pk_sheet_music_audios primary key (sheet_music_id,audio_id)
);

-- foreign keys and indices
create index ix_category_parent_id on category (parent_id);
alter table category add constraint fk_category_parent_id foreign key (parent_id) references category (id) on delete restrict on update restrict;

create index ix_lifecycle_log_sheet_music_id on lifecycle_log (sheet_music_id);
alter table lifecycle_log add constraint fk_lifecycle_log_sheet_music_id foreign key (sheet_music_id) references sheet_music (id) on delete restrict on update restrict;

create index ix_rating_sheet_music_id on rating (sheet_music_id);
alter table rating add constraint fk_rating_sheet_music_id foreign key (sheet_music_id) references sheet_music (id) on delete restrict on update restrict;

create index ix_sheet_music_key_signatures_sheet_music_id on sheet_music_key_signatures (sheet_music_id);
alter table sheet_music_key_signatures add constraint fk_sheet_music_key_signatures_sheet_music_id foreign key (sheet_music_id) references sheet_music (id) on delete restrict on update restrict;

create index ix_sheet_music_categories_sheet_music on sheet_music_categories (sheet_music_id);
alter table sheet_music_categories add constraint fk_sheet_music_categories_sheet_music foreign key (sheet_music_id) references sheet_music (id) on delete restrict on update restrict;

create index ix_sheet_music_categories_category on sheet_music_categories (category_id);
alter table sheet_music_categories add constraint fk_sheet_music_categories_category foreign key (category_id) references category (id) on delete restrict on update restrict;

create index ix_sheet_music_audios_sheet_music on sheet_music_audios (sheet_music_id);
alter table sheet_music_audios add constraint fk_sheet_music_audios_sheet_music foreign key (sheet_music_id) references sheet_music (id) on delete restrict on update restrict;

create index ix_sheet_music_audios_audio on sheet_music_audios (audio_id);
alter table sheet_music_audios add constraint fk_sheet_music_audios_audio foreign key (audio_id) references audio (id) on delete restrict on update restrict;

