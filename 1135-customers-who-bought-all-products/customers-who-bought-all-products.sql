# Write your MySQL query statement below
select customer_id from customer
group by customer_id
having count(distinct product_key) = (select count(distinct product_key)from product) 
 # count(distinct product_key) ye dekhega customer_id mein kitne product hain
 # select count(distinct product_key)from product ye product table mein total product calculate krega 
 # aur jab dono ka value same ho jaega toh bas whi group by karke customer_id mein bas customer_id ka value return kr dega 