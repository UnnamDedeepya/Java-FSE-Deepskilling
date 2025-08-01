import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) throw new Error('Failed to fetch posts');
        return response.json();
      })
      .then(data => {
        const postList = data.slice(0, 5).map(
          post => new Post(post.id, post.title, post.body)
        );
        this.setState({ posts: postList });
      })
      .catch(error => {
        console.error("Error loading posts:", error);
        this.setState({ hasError: true });
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("Something went wrong: " + error);
    console.error("Error caught in component:", error, info);
    this.setState({ hasError: true });
  }

  render() {
    if (this.state.hasError) {
      return <h2 style={{ color: 'red' }}>Error loading posts!</h2>;
    }

    return (
      <div style={{ padding: '20px' }}>
        <h1>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ marginBottom: '20px' }}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
