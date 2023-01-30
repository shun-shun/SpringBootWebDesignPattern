DELETE FROM t_report;
DELETE FROM m_user;

INSERT INTO m_user (user_id, encrypted_password, enabled, user_name, role)
VALUES('aaa@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', false, '太郎', 'ROLE_ADMIN');
INSERT INTO m_user (user_id, encrypted_password, enabled, user_name, role)
VALUES('bbb@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', false, '次郎', 'ROLE_GENERAL');
INSERT INTO m_user (user_id, encrypted_password, enabled, user_name, role)
VALUES('ccc@xxx.co.jp', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', true,'三郎', 'ROLE_GENERAL');

INSERT INTO t_report (id, title, priority, tag, contents, user_id, create_date, update_date) VALUES (1, 'あれやる', 1, 'S構しか勝たん', 'ほげほげ', 'aaa@xxx.co.jp', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO t_report (id, title, priority, tag, contents, user_id, create_date, update_date) VALUES (2, 'これやる', 2, 'FW開発しか勝たん,ゼミしか勝たん', 'ふげふげ', 'bbb@xxx.co.jp', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO t_report (id, title, priority, tag, contents, user_id, create_date, update_date) VALUES (3, 'それやる', 3, 'ゼミしか勝たん', 'もげもげ', 'ccc@xxx.co.jp', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);