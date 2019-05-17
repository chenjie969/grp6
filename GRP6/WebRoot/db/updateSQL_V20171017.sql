ALTER TABLE pro_costmust ADD costMustState VARCHAR(10);

ALTER TABLE pro_costpre ADD costPreState VARCHAR(10);
ALTER TABLE pro_costpre ADD loanPlan_ID VARCHAR(32);
ALTER TABLE pro_costpre ADD costMust_ID VARCHAR(32);


ALTER TABLE pro_costFact ADD costFactState VARCHAR(10);
ALTER TABLE pro_costFact ADD loanPlan_ID VARCHAR(32);
ALTER TABLE pro_costFact ADD costPre_ID VARCHAR(32);
ALTER TABLE pro_costFact ADD planFactCostDate DATETIME;
