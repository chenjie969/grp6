/*========是否新客户====pro_project==*/
ALTER TABLE pro_project ADD COLUMN isNewClient BOOLEAN DEFAULT 0 AFTER beforeEndDesc;
