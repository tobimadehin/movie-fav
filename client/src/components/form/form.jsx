import { React, useState } from 'react'
import { FileUploader } from "react-drag-drop-files";
import PropTypes from 'prop-types'
import './form.css'

const Form = (props) => {
  const fileTypes = ["JPEG", "PNG", "GIF"];
  const [file, setFile] = useState(null);
  const handleChange = (file) => {
    setFile(file);
  };

  return (
    <div className={`form-container form-root-class-name`}>
      <div className="form-form">
        <input
          type="text"
          placeholder={props.title_placeholder}
          required
          autoFocus
          autoComplete="title"
          className="form-textinput input"
        />
        <select
          required
          autoFocus
          autoComplete="category"
          className="form-select input"
        >
          <option value="Action">Action</option>
          <option value="Comedy">Comedy</option>
          <option value="Sci-Fi">Sci-Fi</option>
        </select>
        <FileUploader
          multiple={true}
          handleChange={handleChange}
          name="file"
          types={fileTypes}
        />
        <textarea
          placeholder="Description"
          autoFocus
          autoComplete="description"
          className="form-textarea textarea"
        ></textarea>
        <button type="submit" className="form-button button">
          {props.button}
        </button>
      </div>
    </div>
  )
}

Form.defaultProps = {
  title_placeholder: 'Title',
  textarea_placeholder: 'Description',
  button: 'Submit',
}

Form.propTypes = {
  title_placeholder: PropTypes.string,
  textarea_placeholder: PropTypes.string,
  button: PropTypes.string,
}

export default Form
