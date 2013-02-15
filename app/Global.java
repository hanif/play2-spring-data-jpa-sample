import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import play.Application;
import play.GlobalSettings;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Global extends GlobalSettings {

    static final String DEFAULT_PERSISTENCE_UNIT = "default";

    final private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

    @Override
    public void onStart(final Application app) {
        ctx.register(SpringDataJpaConfiguration.class);
        ctx.scan("controllers", "models", "repositories", "services");
        ctx.refresh();
        ctx.start();
        super.onStart(app);
    }

    @Override
    public void onStop(final Application app) {
        ctx.close();
        super.onStop(app);
    }

    @Override
    public <A> A getControllerInstance(Class<A> aClass) {
        return ctx.getBean(aClass);
    }

    @Configuration
    @EnableJpaRepositories(value = {"models", "repositories"})
    public static class SpringDataJpaConfiguration {

        @Bean
        public EntityManagerFactory entityManagerFactory() {
            return Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCE_UNIT);
        }

        @Bean
        public HibernateExceptionTranslator hibernateExceptionTranslator() {
            return new HibernateExceptionTranslator();
        }

        @Bean
        public JpaTransactionManager transactionManager() {
            return new JpaTransactionManager();
        }
    }
}
