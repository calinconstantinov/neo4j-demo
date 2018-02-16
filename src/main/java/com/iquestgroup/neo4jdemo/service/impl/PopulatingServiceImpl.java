package com.iquestgroup.neo4jdemo.service.impl;

import com.google.common.collect.Sets;
import com.iquestgroup.neo4jdemo.model.Actor;
import com.iquestgroup.neo4jdemo.model.Movie;
import com.iquestgroup.neo4jdemo.model.Rating;
import com.iquestgroup.neo4jdemo.model.User;
import com.iquestgroup.neo4jdemo.repository.MovieRepository;
import com.iquestgroup.neo4jdemo.repository.RatingRepository;
import com.iquestgroup.neo4jdemo.repository.UserRepository;
import com.iquestgroup.neo4jdemo.repository.custom.HelperGraphRepository;
import com.iquestgroup.neo4jdemo.service.PopulatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class PopulatingServiceImpl implements PopulatingService {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RatingRepository ratingRepository;

  @Autowired
  private HelperGraphRepository helperGraphRepository;

  @Override
  @Transactional
  public void deleteGraph() {
    getHelperGraphRepository().deleteGraph();
  }

  @Override
  @Transactional
  public synchronized void populateManyMovies() {
    for (int i = 0; i < 180; i++) {
      Movie movie = new Movie();
      movie.setTitle("movie" + String.format("%03d", i + 1));
      getMovieRepository().save(movie);
    }
  }

  @Override
  @Transactional
  public synchronized void deleteAndPopulate() {
    deleteGraph();
    populateDb();
  }

  @Override
  @Transactional
  public synchronized void populateDb() {
    Movie hp1 = new Movie();
    hp1.setTitle("Harry Potter and the Sorcerer's Stone");
    Movie hp2 = new Movie();
    hp2.setTitle("Harry Potter and the Chamber of Secrets");

    Actor daniel = new Actor();
    daniel.setName("Daniel Radcliffe");
    daniel.actedIn(Sets.newHashSet(hp1, hp2));

    Actor emma = new Actor();
    emma.setName("Emma Watson");
    emma.actedIn(Sets.newHashSet(hp1, hp2));
    getMovieRepository().save(hp1);

    Actor rupert = new Actor();
    rupert.setName("Rupert Grint");
    rupert.actedIn(Sets.newHashSet(hp1));
    getMovieRepository().save(hp2);

    // ACTED_IN relationship is present on both sides. One options is to save it on both entities. Take caution not to
    // affect existing relationships.
    Movie itw = new Movie();
    itw.setTitle("Into the White");
    Set<Movie> rupertMovies = rupert.getMovies();
    rupertMovies.add(itw);
    rupert.actedIn(rupertMovies);
    getMovieRepository().save(itw);

    Movie hp3 = new Movie();
    hp3.setTitle("Harry Potter and the Prisoner of Azkaban");
    hp3.actedIn(Sets.newHashSet(daniel, emma, rupert));
    getMovieRepository().save(hp3);

    // WATCHED is only present on User. No special caution needed.
    User calin = new User();
    calin.setName("calin");
    calin.setMoviesWatched(Sets.newHashSet(hp1, hp2, hp3, itw));
    getUserRepository().save(calin);

    User gabi = new User();
    gabi.setName("gabi");
    gabi.setMoviesWatched(Sets.newHashSet(hp1, hp2));
    getUserRepository().save(gabi);

    User nicoleta = new User();
    nicoleta.setName("nicoleta");
    nicoleta.setMoviesWatched(Sets.newHashSet(hp1, itw));
    getUserRepository().save(nicoleta);

    User razvan = new User();
    razvan.setName("razvan");
    razvan.setMoviesWatched(Sets.newHashSet(hp1, hp2, itw));
    getUserRepository().save(razvan);

    User bogdan = new User();
    bogdan.setName("bogdan");
    bogdan.setMoviesWatched(Sets.newHashSet(hp1, itw));
    getUserRepository().save(bogdan);

    Rating calinHp1Rating = new Rating();
    calinHp1Rating.setMovie(hp1);
    calinHp1Rating.setUser(calin);
    calinHp1Rating.setStars(5);

    Rating calinHp2Rating = new Rating();
    calinHp2Rating.setMovie(hp2);
    calinHp2Rating.setUser(calin);
    calinHp2Rating.setStars(4);

    Rating calinHp3Rating = new Rating();
    calinHp3Rating.setMovie(hp3);
    calinHp3Rating.setUser(calin);
    calinHp3Rating.setStars(5);

    Rating calinItwRating = new Rating();
    calinItwRating.setMovie(itw);
    calinItwRating.setUser(calin);
    calinItwRating.setStars(2);

    Rating nicoletaHp1Rating = new Rating();
    nicoletaHp1Rating.setMovie(hp1);
    nicoletaHp1Rating.setUser(nicoleta);
    nicoletaHp1Rating.setStars(1);

    Rating bogdanItwRating = new Rating();
    bogdanItwRating.setMovie(hp1);
    bogdanItwRating.setUser(bogdan);
    bogdanItwRating.setStars(3);

    Rating bogdanHp3Rating = new Rating();
    bogdanHp3Rating.setMovie(hp3);
    bogdanHp3Rating.setUser(bogdan);
    bogdanHp3Rating.setStars(5);

    Rating gabiHp1Rating = new Rating();
    gabiHp1Rating.setMovie(hp1);
    gabiHp1Rating.setUser(gabi);
    gabiHp1Rating.setStars(3);

    Rating razvanItwRating = new Rating();
    razvanItwRating.setMovie(itw);
    razvanItwRating.setUser(razvan);
    razvanItwRating.setStars(1);

    // only ratings are saved. users and movies should be reloaded to correctly see these new relationships.
    getRatingRepository().save(calinHp1Rating);
    getRatingRepository().save(calinHp2Rating);
    getRatingRepository().save(calinHp3Rating);
    getRatingRepository().save(calinItwRating);
    getRatingRepository().save(nicoletaHp1Rating);
    getRatingRepository().save(bogdanItwRating);
    getRatingRepository().save(bogdanHp3Rating);
    getRatingRepository().save(gabiHp1Rating);
    getRatingRepository().save(razvanItwRating);
  }

  public MovieRepository getMovieRepository() {
    return movieRepository;
  }

  public UserRepository getUserRepository() {
    return userRepository;
  }

  public RatingRepository getRatingRepository() {
    return ratingRepository;
  }

  public HelperGraphRepository getHelperGraphRepository() {
    return helperGraphRepository;
  }

}
