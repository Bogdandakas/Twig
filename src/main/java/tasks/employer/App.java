package tasks.employer;

import sun.rmi.log.LogHandler;
import tasks.employer.beans.Twig;
import tasks.employer.service.TwigService;
import tasks.employer.service.TwigServiceImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final String DEEPEST_LEVEL = "The deepest level of tree";
    private static final String TYPE_MANUALLY = "(created manually) is: ";
    private static final String TYPE_RANDOM = "(created random) is: ";

    private static Logger logger = Logger.getLogger(LogHandler.class.getName());

    public static void main(String[] args) {

        runApp();
    }

    private static void runApp() {

        TwigService service = new TwigServiceImpl();

        int result = service.getMaxLevel(createTree());
        logger.log(Level.INFO, DEEPEST_LEVEL + TYPE_MANUALLY + result);

        int result2 = service.getMaxLevel(service.createTreeRandom());
        logger.log(Level.INFO, DEEPEST_LEVEL + TYPE_RANDOM + result2);
    }

    private static Twig createTree() {

        Twig tree = new Twig();

        tree.getTwigs().add(new Twig());
        tree.getTwigs().add(new Twig());

        tree.getTwigs().get(0).getTwigs().add(new Twig());
        tree.getTwigs().get(1).getTwigs().add(new Twig());
        tree.getTwigs().get(1).getTwigs().add(new Twig());
        tree.getTwigs().get(1).getTwigs().add(new Twig());

        tree.getTwigs().get(1).getTwigs().get(0).getTwigs().add(new Twig());
        tree.getTwigs().get(1).getTwigs().get(1).getTwigs().add(new Twig());
        tree.getTwigs().get(1).getTwigs().get(1).getTwigs().add(new Twig());

        tree.getTwigs().get(1).getTwigs().get(1).getTwigs().get(0).getTwigs().add(new Twig());

        return tree;
    }


}