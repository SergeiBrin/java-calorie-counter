public class Converter {
    double kiloCalories;
    double distance;

    Converter(double steps) {
        distance = steps * 0.00075;
        kiloCalories = steps * 0.05;
    }
}
