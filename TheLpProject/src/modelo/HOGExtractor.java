package modelo;

import java.util.List;

import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

public class HOGExtractor {
	
	public List<Float> extraction(){
		HOGDescriptor hog = new HOGDescriptor();
		Mat img = new Mat();
		MatOfFloat features = new MatOfFloat();
		img = Imgcodecs.imread("C:\\Users\\user\\Pictures\\wp\\mucei.png", Imgcodecs.IMREAD_GRAYSCALE);
		Imgproc.resize(img, img, new Size(64,128), 0.5, 0.5, Imgproc.INTER_LINEAR);
		hog.compute(img, features);
		List<Float> arrayOfFeatures = features.toList();
		List<Float> arrayResized = arrayOfFeatures.subList(0, 1000);
		return arrayResized;
	}
	
}
