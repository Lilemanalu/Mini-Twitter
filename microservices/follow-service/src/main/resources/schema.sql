CREATE TABLE IF NOT EXISTS `follows` (
  `id` UUID PRIMARY KEY,
  `user_id` UUID NOT NULL,         -- The user being followed
  `follower_id` UUID NOT NULL,     -- The user who is following
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE (`user_id`, `follower_id`) -- Prevents duplicate follow records
);

