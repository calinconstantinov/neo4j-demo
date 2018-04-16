package ro.ace.ucv.neo4j.controller;

import ro.ace.ucv.neo4j.model.Movie;
import ro.ace.ucv.neo4j.model.User;
import ro.ace.ucv.neo4j.model.queryresult.MovieAverageRatingData;
import ro.ace.ucv.neo4j.model.queryresult.MoviesCommonActorsData;
import ro.ace.ucv.neo4j.service.MovieService;
import ro.ace.ucv.neo4j.service.PopulatingService;
import ro.ace.ucv.neo4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Hello {

  @Autowired
  private UserService userService;

  @Autowired
  private MovieService movieService;

  @Autowired
  private PopulatingService populatingService;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String helloWorld() {
    clearAndFillData();
    getMoviePage();
    getUsersThatViewedHp1();
    getHp1Rating();
    getCommonActorNumbers();
    performRecommendation();

    return "index";
  }

  private void clearAndFillData() {
    populatingService.deleteAndPopulate();
  }

  private void getMoviePage() {
    populatingService.populateManyMovies();
    List<Movie> moviePage = movieService.findMovies(3, 10);
    for (Movie movie : moviePage) {
      System.out.print(movie.getTitle() + " ");
    }
    System.out.println();
  }


  private void getUsersThatViewedHp1() {
    List<User> users = userService.findUsersThatWatchedMovieFromTitle("Harry Potter and the Sorcerer's Stone");
    for (User user : users) {
      System.out.print(user.getName() + " ");
    }
    System.out.println();
  }

  private void getHp1Rating() {
    MovieAverageRatingData movieAverageRatingData =
        movieService.findMovieAverageRatingData("Harry Potter and the Sorcerer's Stone");
    System.out.println(movieAverageRatingData.getMovie().getTitle() + ": " + movieAverageRatingData.getAverageRating());
  }

  private void getCommonActorNumbers() {
    List<MoviesCommonActorsData> moviesCommonActorsDataList = movieService.findMoviePairsWithMostCommonActors();
    for (MoviesCommonActorsData moviesCommonActorsData : moviesCommonActorsDataList) {
      System.out.print(moviesCommonActorsData.getNoOfCommonActors() + " ");
    }
    System.out.println();
  }

  private void performRecommendation() {
    List<Movie> movies = movieService.findMoviesToRecommend("gabi");
    for (Movie movie : movies) {
      System.out.print(movie.getTitle() + " ");
    }
    System.out.println();
  }

}
