public class Converter {
    float kiloCalories;
    float distance;

    Converter(float steps) {
        distance = (float) (steps * 0.00075);
        kiloCalories = (float) (steps * 0.05);
    }
}
