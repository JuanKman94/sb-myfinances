package mx.geckox.myfin.controllers;

import mx.geckox.myfin.api.CategoryRequest;
import mx.geckox.myfin.entities.Category;
import mx.geckox.myfin.exceptions.ModelNotFoundException;
import mx.geckox.myfin.repositories.CategoriesRepository;
import mx.geckox.myfin.services.CategoriesService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/categories")
public class CategoriesController {
  @Autowired
  private CategoriesService categoriesService;

  private static final Logger log = LogManager.getLogger(CategoriesController.class);

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Iterable<Category> all() {
    return this.categoriesService.all();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity get(@PathVariable Long id) throws ModelNotFoundException {
    return new ResponseEntity<>(this.categoriesService.find(id), HttpStatus.OK);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseEntity<?> create(@RequestBody CategoryRequest payload) {
    log.info("Creating Category with {}", payload);
    return new ResponseEntity<>(this.categoriesService.create(payload), HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<?> update(
      @PathVariable Long id,
      @RequestBody CategoryRequest payload
  ) throws ModelNotFoundException {
    return new ResponseEntity<>(this.categoriesService.update(id, payload), HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity delete(@PathVariable Long id) {
    this.categoriesService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
