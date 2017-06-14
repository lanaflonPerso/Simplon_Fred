select * from country where country like 'k%';
select count(*) as Total_50 from film where length < 50;
select count(*), category.name from film inner join film_category on film.film_id = film_category.film_id inner join category on film_category.category_id = category.category_id where category.category_id = 1;
select film.title, language.name from film inner join language on film.language_id = language.language_id;
select actor.first_name, actor.last_name, category.name from actor inner join film_actor on actor.actor_id = film_actor.actor_id inner join film_category on film_category.film_id = film_actor.film_id inner join category on film_category.category_id = category.category_id where category.category_id = 2 group by actor.actor_id order by actor.last_name asc, actor.first_name asc;
select * from film order by rental_duration desc;
