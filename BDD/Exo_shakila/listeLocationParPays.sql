select count(*), country.country from rental inner join customer on rental.customer_id = customer.customer_id inner join address on customer.address_id = address.address_id inner join city on address.city_id = city.city_id inner join country on city.country_id = country.country_id group by country.country;

