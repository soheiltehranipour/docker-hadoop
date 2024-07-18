package UBR;
import java.io.File;
import java.util.List;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.RMSRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.SpearmanCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.common.RandomUtils;

public class UserRecommendation {
    public static void main(String[] args) throws Exception {
        DataModel model = new FileDataModel(new File('dataset-recsys.csv'));
        RecommenderBuilder rb = new RecommenderBuilder() {
            public Recommender buildRecommender(DataModel model) throws TasteException {
                UserSimilarity sim = new PearsonCorrelationSimilarity(model);
                UserNeighborhood un = new NearestNUserNeighborhood(100, sim, model);
                return new GenericUserBasedRecommender(model, un, sim);
            }
        }
        Recommender r = rb.buildRecommender(model);
        List<RecommendedItem> ri = r.recommend(9, 5);
        System.out.println(ri);
    }
}
/* Mukesh Chapagain Blog */