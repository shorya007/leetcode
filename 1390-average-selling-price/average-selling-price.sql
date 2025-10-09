# Write your MySQL query statement below
select p.product_id,
-- //p.price * u.units → total revenue for that period
-- SUM(p.price * u.units) → total revenue for all periods
-- SUM(u.units) → total units sold
ifnull(round(sum(p.price * u.units)/sum(u.units),2),0) as average_price
from prices p
left join unitssold u
on p.product_id = u.product_id
-- We must join Prices and UnitsSold such that:
-- product_id is same
-- purchase_date lies between start_date and end_date
and u.purchase_date between p.start_date and p.end_date
group by product_id