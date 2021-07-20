DELETE FROM t_report;
DELETE FROM m_user;

INSERT INTO m_user (user_id, encrypted_password, enabled, user_name, role)
VALUES('ikeda@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', false, '池田', 'ROLE_ADMIN');
INSERT INTO m_user (user_id, encrypted_password, enabled, user_name, role)
VALUES('tamura@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', false, '田村', 'ROLE_GENERAL');
INSERT INTO m_user (user_id, encrypted_password, enabled, user_name, role)
VALUES('suzuki@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', true,'鈴木', 'ROLE_GENERAL');

INSERT INTO t_report (id, title, priority, contents, user_id, create_date) VALUES (1, 'あれやる', 1, 'ほげほげ', 'ikeda@xxx.co.jp', systimestamp);
INSERT INTO t_report (id, title, priority, contents, user_id, create_date) VALUES (2, 'これやる', 2, 'ふげふげ', 'tamura@xxx.co.jp', systimestamp);
INSERT INTO t_report (id, title, priority, contents, user_id, create_date) VALUES (3, 'それやる', 3, 'もげもげ', 'suzuki@xxx.co.jp', systimestamp);