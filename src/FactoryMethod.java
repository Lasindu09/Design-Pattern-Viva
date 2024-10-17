public class FactoryMethod {
}
abstract class Vehicle {
    public abstract void printVehicle();
}
class Bike extends Vehicle {
    public void printVehicle() {
        System.out.println("I have a Bike");
    }
}
class ThreeWheel extends Vehicle{
    public void printVehicle(){
        System.out.println("I have a Three Wheel");
    }
}
class Car extends Vehicle {
    public void printVehicle() {
        System.out.println("I have a Car");
    }
}

// Client class
class Client {
    private Vehicle pVehicle;

    public Client(int type) {
        if (type == 2) {
            pVehicle = new Bike();
        } else if (type == 3){
            pVehicle = new ThreeWheel();
        } else if (type == 4) {
            pVehicle = new Car();
        } else {
            pVehicle = null;
        }
    }
    public Vehicle getVehicle() {
        return pVehicle;
    }
}
// Driver class
class Driver {
    public static void main(String[] args) {
        Client pClient = new Client(2);
        Vehicle pVehicle = pClient.getVehicle();
        if (pVehicle != null) {
            pVehicle.printVehicle();
        }
    }
}