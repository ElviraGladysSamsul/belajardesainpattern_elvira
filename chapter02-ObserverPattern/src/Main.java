public class Main {
    public static void main(String[] args) {
        Channel ch = new Channel("Elvira Gladys Channel");
        User user1 = new User("Reval");
        User user2 = new User("Liza TV");
        User user3 = new User("Pira");

        ch.addSubscriber(user1);
        ch.addSubscriber(user2);
        ch.notifyUser("Ada video baru buat anda! Jangan lupa di subscribe ya!");

        user3.subscribe(ch);
        ch.notifyUser("Video baru!");
    }
}
