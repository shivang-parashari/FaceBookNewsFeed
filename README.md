# FaceBookNewsFeed

## Overview

FaceBookNewsFeed is a simple Java-based simulation of a social network where users can interact by posting content, following other users, commenting on posts, and voting on posts. The posts are displayed on a user’s news feed, sorted based on a set of criteria.

## Features

- **Post**: Users can create posts, which are displayed on their profile and can be interacted with by others.
- **Follow**: Users can follow other users to receive updates on their posts in their news feed.
- **Reply (Comment)**: Users can comment on posts made by other users.
- **Upvote/Downvote**: Users can vote on posts, influencing the visibility of the posts in the feed.
- **Show News Feed**: Users can view their news feed with posts from those they follow. Posts are sorted based on the following criteria:
  1. **Followed users**: Posts by followed users appear first.
  2. **Score**: Posts with higher scores (upvotes - downvotes) are prioritized.
  3. **Number of Comments**: Posts with more comments are shown higher.
  4. **Timestamp**: Newer posts are ranked higher if all other factors are equal.

## Commands and Input Format

The system works by accepting input commands in the following format:

- Commands consist of keywords like `signup`, `login`, `post`, `follow`, `reply`, `upvote`, `downvote`, and `shownewsfeed`.
- Arguments are separated by a special character `~` (tilde).

### Command Structure:

- **signup~<username>**: Registers a new user with the given username.
- **login~<username>**: Logs in the user with the specified username.
- **post~<content>**: A logged-in user can post content.
- **follow~<username>**: A logged-in user follows another user

