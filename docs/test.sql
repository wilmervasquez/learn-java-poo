CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE folders (
     id SERIAL PRIMARY KEY,
     parent_id INT,
     name VARCHAR(100) NOT NULL,
     user_id INT NOT NULL,
     FOREIGN KEY (parent_id) REFERENCES folders(id),
     FOREIGN KEY (user_id) REFERENCES users(id)
);

ALTER TABLE folders
ADD CONSTRAINT chk_parent_not_self
CHECK (parent_id IS NULL OR parent_id <> id);


CREATE TABLE bookmarks (
    id SERIAL PRIMARY KEY,
    folder_id INT NOT NULL,
    title VARCHAR(200) NOT NULL,
    url TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    FOREIGN KEY (folder_id) REFERENCES folders(id)
);

INSERT INTO users (name) VALUES
('Juan'),
('Maria'),
('Pedro'),
('Diego'),
('Vanesa'),
('Ashly'),
('Aemy'),
('Ronaldo');

INSERT INTO folders (parent_id, name, user_id) VALUES
(NULL, 'Docs', 7),
(NULL, 'Books', 7),
(2, 'Dev', 2),
(2, 'Dev', 2);

INSERT INTO bookmarks (folder_id, title, url) VALUES
(9, 'Google', 'https://minenter.com/software'),
(9, 'Snippet', 'https://google.com'),
(10, 'Education', 'https://minenter.com/software');

SELECT * FROM users;
SELECT * FROM folders;
SELECT * FROM bookmarks;

WITH RECURSIVE folder_tree AS (
    SELECT id, parent_id, name, 1 AS depth
    FROM folders
    WHERE parent_id IS NULL

    UNION ALL

    SELECT f.id, f.parent_id, f.name, ft.depth + 1
    FROM folders f
             INNER JOIN folder_tree ft ON f.parent_id = ft.id
) SELECT * FROM folder_tree;

SELECT * FROM folders WHERE user_id = 7 AND parent_id IS NULL;
SELECT
    b.id,
    b.title,
    b.url,
    b.folder_id
FROM bookmarks b
JOIN folders f ON b.folder_id = f.id
WHERE f.user_id = 7;



WITH RECURSIVE tree AS (
    SELECT id, parent_id, name, 0 AS depth
    FROM folders
    WHERE parent_id IS NULL AND user_id = 7

    UNION ALL

    SELECT f.id, f.parent_id, f.name, t.depth + 1
    FROM folders f
        JOIN tree t ON f.parent_id = t.id
)
SELECT * FROM tree ORDER BY depth, name;


-- ------------------------
