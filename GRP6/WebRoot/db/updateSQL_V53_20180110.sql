/*============业务代偿信息表pro_replace==*/
ALTER TABLE pro_replace ADD COLUMN replaceFactDate Date AFTER replaceDate;
/*============业务追偿信息表pro_returnDetail==*/
ALTER TABLE pro_returnDetail ADD COLUMN returnFactDate Date AFTER returnDate;