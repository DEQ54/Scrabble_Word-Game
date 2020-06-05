package application;

public class PointsProcessAlgorithm {
	static int points=0;
	public static void IncreasePoints() {
		points+=3;
		if(points<10) {
		GameComponents.AssignedScorePoints.setText("0"+points+"");
	}else {
		GameComponents.AssignedScorePoints.setText(points+"");
	}
	}
}
