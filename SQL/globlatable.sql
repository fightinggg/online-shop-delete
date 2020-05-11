CREATE TABLE `globalId`  (
                             `id` int(20) NOT NULL,
                             `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             PRIMARY KEY (`id`)
);