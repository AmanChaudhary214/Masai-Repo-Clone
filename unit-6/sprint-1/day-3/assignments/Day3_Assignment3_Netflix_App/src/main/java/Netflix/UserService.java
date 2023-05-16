package Netflix;

public class UserService {

	RecommendationService recommendationService;

//	public UserService(RecommendationService recommendationService) {
//		super();
//		this.recommendationService = recommendationService;
//	}

	public void setRecommendationService(RecommendationService recommendationService) {
		this.recommendationService = recommendationService;
	}
	
	public void netflix() {
		System.out.println("Welcome to Netflix");
	}
	
}
