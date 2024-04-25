public interface Observable {
    public void addSubscriber(User user);
    public void removeSubscriber(User user);
    public void notifyUser(String msg);
}