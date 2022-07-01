public class Converter {
    float kiloCalories = 0f;
    float distance = 0f;

    Converter(float steps) {
        distance = (float) (steps * 0.00075);
        kiloCalories = (float) (steps * 0.05);
    }
}
