/*============还款日期==*/
ALTER TABLE pro_factPay ADD COLUMN factDate DATE AFTER payDate;
/*============逾期日期==*/
ALTER TABLE pro_project ADD COLUMN overFactDate DATE AFTER overDate;
/*============展期日期==*/
ALTER TABLE pro_delay ADD COLUMN factBeginDate DATE AFTER delayBeginDate;
