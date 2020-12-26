--liquibase formatted sql
--changeset Peter Cirbes:1 context:integration-test

INSERT INTO beer (id, beer_name, beer_style, created_date, last_modified_date, min_on_hand,price, quantity_to_brew, upc, version) VALUES
('2050245f-c1f1-4b05-ab52-9b315c6310db','Galaxy Cat','PALE','2020-10-26 22:51:36.653185','2020-10-26 22:51:36.653203',12,11.95,200,3370102,0),
('41c4ed46-9321-4f78-97c4-b62802bc046d','Mango Bobs','IPA','2020-10-26 22:51:36.643934','2020-10-26 22:51:36.644376',12,12.95,200,3370101,0);