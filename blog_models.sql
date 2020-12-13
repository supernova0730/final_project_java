CREATE TABLE category (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);


CREATE TABLE article (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    min_content VARCHAR(1023) NOT NULL,
    content TEXT NOT NULL,
    date_created DATETIME DEFAULT current_timestamp,
    category_id INTEGER,
    image VARCHAR(255) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);

CREATE TABLE comment (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(25) NOT NULL,
    email VARCHAR(25) NOT NULL,
    content TEXT NOT NULL,
    date_created DATETIME DEFAULT current_timestamp,
    article_id INTEGER,
    FOREIGN KEY (article_id) REFERENCES article(id) ON DELETE CASCADE
);
