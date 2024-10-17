public class Facade {
}
interface Menus {
    void showMenu();
}
class VegMenu implements Menus {
    @Override
    public void showMenu() {
        System.out.println("Displaying Vegetarian Menu");
    }
}
class NonVegMenu implements Menus {
    @Override
    public void showMenu() {
        System.out.println("Displaying Non-Vegetarian Menu");
    }
}
class Both implements Menus {
    @Override
    public void showMenu() {
        System.out.println("Displaying Both Menus");
    }
}
interface Hotel {
    Menus getMenus();
}
class NonVegRestaurant implements Hotel {
    @Override
    public Menus getMenus() {
        return new NonVegMenu();
    }
}
class VegRestaurant implements Hotel {
    @Override
    public Menus getMenus() {
        return new VegMenu();
    }
}
class VegNonBothRestaurant implements Hotel {
    @Override
    public Menus getMenus() {
        return new Both();
    }
}
interface HotelKeeper {
    VegMenu getVegMenu();
    NonVegMenu getNonVegMenu();
    Both getVegNonMenu();
}
class HotelKeeperImplementation implements HotelKeeper {
    @Override
    public VegMenu getVegMenu() {
        VegRestaurant veg = new VegRestaurant();
        return (VegMenu) veg.getMenus();
    }
    @Override
    public NonVegMenu getNonVegMenu() {
        NonVegRestaurant veg = new NonVegRestaurant();
        return (NonVegMenu) veg.getMenus();
    }
    @Override
    public Both getVegNonMenu() {
        VegNonBothRestaurant veg = new VegNonBothRestaurant();
        return (Both) veg.getMenus();
    }
}
class Customer {
    public static void main(String[] args) {
        HotelKeeper keeper = new HotelKeeperImplementation();

        VegMenu veg = keeper.getVegMenu();
        veg.showMenu();

        NonVegMenu nonVeg = keeper.getNonVegMenu();
        nonVeg.showMenu();

        Both both = keeper.getVegNonMenu();
        both.showMenu();
    }
}
