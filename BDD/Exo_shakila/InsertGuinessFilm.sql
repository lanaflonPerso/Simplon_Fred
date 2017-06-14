truncate table `guiness`; 
INSERT INTO guiness (film) 
SELECT film.title FROM film INNER JOIN film_actor ON film.film_id = film_actor.film_id INNER JOIN actor ON actor.actor_id = film_actor.actor_id WHERE actor.last_name = "GUINESS"  AND actor.first_name = "Penelope"