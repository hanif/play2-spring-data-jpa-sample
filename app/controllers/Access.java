package controllers;

import models.User;
import org.mindrot.jbcrypt.BCrypt;
import play.data.Form;
import play.db.jpa.JPA;
import play.mvc.Controller;
import play.mvc.Result;

import repositories.UserRepository;
import views.html.access.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Named
@Singleton
public class Access extends Controller {

    private final UserRepository userRepository;

    @Inject
    public Access(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static class Login {

        public String email;
        public String password;

        public String validate() {
            Query query = JPA.em().createQuery("select u from User u where u.email = :email");
            query.setParameter("email", email);

            try {
                User user = (User) query.getSingleResult();
                if (BCrypt.checkpw(password, user.getPassword())) {
                    return null;
                }
            } catch (NoResultException e) {}

            return "Invalid identity or credentials";
        }
    }

    public Result login() {
        if (userRepository != null) {
            return redirect(routes.Dashboard.index());
        }
        return ok(login.render(Form.form(Login.class)));
    }

    @Transactional
    public Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("email", loginForm.get().email);
            return redirect(routes.Dashboard.index());
        }
    }

    public Result logout() {
        session().remove("email");
        flash("info", "You've successfully logged out.");
        return redirect(routes.Access.login());
    }

    public Result forgotPassword() {
        return TODO;
    }

    public Result resetPassword() {
        return TODO;
    }

    public Result register() {
        return TODO;
    }

    public Result fromInvitation() {
        return TODO;
    }
}
