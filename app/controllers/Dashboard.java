package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.dashboard.*;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class Dashboard extends Controller {

    public Result index() {
        return ok(index.render());
    }
}
