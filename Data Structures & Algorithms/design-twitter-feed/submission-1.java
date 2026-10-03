class Twitter {
    int time;
    Map<Integer, List<Post>> userToPost;
    Map<Integer, Set<Integer>> userToFollowee;

    public Twitter() {
        time = 0;
        userToPost = new HashMap<>();
        userToFollowee = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (userToPost.get(userId) == null) {
            userToPost.put(userId, new ArrayList<>());
        }
        userToPost.get(userId).add(new Post(time, userId, tweetId, userToPost.get(userId).size()));
        time += 1;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> posts = new PriorityQueue<>((a,b) -> b.time-a.time);
        List<Integer> feed = new ArrayList<>();
        if (userToFollowee.get(userId) == null) {
            userToFollowee.put(userId, new HashSet<>());
        }
        userToFollowee.get(userId).add(userId);
        for (Integer user : userToFollowee.get(userId)) {
            if (userToPost.get(user) != null && userToPost.get(user).size() > 0) {
                posts.offer(userToPost.get(user).get(userToPost.get(user).size()-1));
            }
        }
        for (int i = 0; i < 10; i++) {
            if (posts.peek() == null) {
                break;
            }
            Post post = posts.poll();
            feed.add(post.tweetId);
            if (post.index>0){
                posts.offer(userToPost.get(post.userId).get(post.index-1));
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (userToFollowee.get(followerId) == null) {
            userToFollowee.put(followerId, new HashSet<>());
        }
        userToFollowee.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userToFollowee.get(followerId).remove(followeeId);
    }

    class Post {
        int time;
        int userId;
        int tweetId;
        int index;
        public Post(int time, int userId, int tweetId, int index) {
            this.time = time;
            this.userId = userId;
            this.tweetId = tweetId;
            this.index = index;
        }
    }
}
