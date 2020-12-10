CREATE TABLE short_url (
  id BIGINT IDENTITY,
  url VARCHAR NOT NULL,
  key VARCHAR NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP NOT NULL,
  UNIQUE(url),
  UNIQUE(key)
)