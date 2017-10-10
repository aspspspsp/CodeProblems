package InteratorPattern;

public class Watress {
	static DinerMenu dinerMenu;

	public static void main(String[] args) {
		dinerMenu = new DinerMenu();
		printMenu();
	}
	
	public static void printMenu() {
		MenuItem[] items = new MenuItem[6];
		for(int i = 0; i < items.length; i ++) {
			items[i] = new MenuItem("A" + i);
		}
		
		Inerator menuInerator = dinerMenu.creatIterator(items);
		printMenu(items);
		
	}
	
	public static void printMenu(Inerator interator) {
		
	}
}
