import React from 'react'

import PropTypes from 'prop-types'

import './movie-card.css'

const MovieCard = (props) => {
  return (
    <div className="movie-card-feature-card">
      <div className="movie-card-container">
        <div className="movie-card-container1">
          <h3 className="movie-card-text heading3">{props.title}</h3>
          <span className="movie-card-text1">{props.username}</span>
        </div>
        <div
          data-thq="thq-dropdown"
          className="movie-card-thq-dropdown list-item"
        >
          <div
            data-thq="thq-dropdown-toggle"
            className="movie-card-dropdown-toggle"
          >
            <svg viewBox="0 0 1024 1024" className="movie-card-icon">
              <path d="M128 554.667h768c23.552 0 42.667-19.115 42.667-42.667s-19.115-42.667-42.667-42.667h-768c-23.552 0-42.667 19.115-42.667 42.667s19.115 42.667 42.667 42.667zM128 298.667h768c23.552 0 42.667-19.115 42.667-42.667s-19.115-42.667-42.667-42.667h-768c-23.552 0-42.667 19.115-42.667 42.667s19.115 42.667 42.667 42.667zM128 810.667h768c23.552 0 42.667-19.115 42.667-42.667s-19.115-42.667-42.667-42.667h-768c-23.552 0-42.667 19.115-42.667 42.667s19.115 42.667 42.667 42.667z"></path>
            </svg>
          </div>
          <ul data-thq="thq-dropdown-list" className="movie-card-dropdown-list">
            <li
              data-thq="thq-dropdown"
              className="movie-card-dropdown list-item"
            >
              <div
                data-thq="thq-dropdown-toggle"
                className="movie-card-dropdown-toggle1"
              >
                <span className="movie-card-text2">Edit</span>
              </div>
            </li>
            <li
              data-thq="thq-dropdown"
              className="movie-card-dropdown1 list-item"
            >
              <div
                data-thq="thq-dropdown-toggle"
                className="movie-card-dropdown-toggle2"
              >
                <span className="movie-card-text3">Delete</span>
              </div>
            </li>
          </ul>
        </div>
      </div>
      <img
        alt={props.image_alt}
        src={props.image_src}
        className="movie-card-image"
      />
      <span className="movie-card-text5">{props.description}</span>
    </div>
  )
}

MovieCard.defaultProps = {
  title: 'Movie title',
  username: 'user001',
  image_alt: 'image',
  image_src:
    'https://images.unsplash.com/photo-1523755231516-e43fd2e8dca5?ixid=Mnw5MTMyMXwwfDF8c2VhcmNofDF8fG1pbmltYWxpc20lMjBjb3VjaHxlbnwwfHx8fDE2MjY0NDg1NTk&ixlib=rb-1.2.1&w=1500',
  description:
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In lorem lorem, malesuada in metus vitae, scelerisque accumsan ipsum.',
}

MovieCard.propTypes = {
  title: PropTypes.string,
  username: PropTypes.string,
  image_alt: PropTypes.string,
  image_src: PropTypes.string,
  description: PropTypes.string,
}

export default MovieCard
