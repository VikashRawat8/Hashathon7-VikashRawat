/* eslint-disable */
import React, { useState } from 'react';
import axios from 'axios';
import MDEditor from '@uiw/react-md-editor';
import mermaid from 'mermaid';
import Tags from '../MyBlog/tags';
import './editor.css';

const mdMermaid = '';

export default function App() {
  const [value, setValue] = useState(mdMermaid);
  const [title,settitle]=useState("React");
  const handleClick = () => {
    const data = {
      content: value,
       title: title,
       author: {
         id: 1
       },
       tagNames: ['react','javascript']  
    };

    console.log(data);
    axios.post("https://ca9e74e6-c0f5-43bf-bbf5-322f06c8162e.mock.pstmn.io/post",data)
        .then((response) => {
              console.log(response);
              alert("Data saved ")
         })
        .catch((err) => {
              console.log(err);
         }); 
  }
  return (
    <>
      <MDEditor
        onChange={(newValue) => setValue(newValue)}
        textareaProps={{
          placeholder: 'Please enter Markdown text',
        }}
        height={600}
        value={value}
        previewOptions={{
          components: {
            code: ({ children, className }) => {
              const txt = children[0] || '';
              if (
                typeof txt === 'string' && typeof className === 'string' && /^language-mermaid/.test(className.toLocaleLowerCase())
              ) {
                const Elm = document.createElement('div');
                Elm.id = 'demo';
                const svg = mermaid.render('demo', txt);
                // eslint-disable-next-line
                return <code dangerouslySetInnerHTML={{ __html: svg }} />;
              }
              return <code className={String(className)}>{txt}</code>;
            },
          },
        }}
      />
      <Tags />
      <div>Title</div>
      <textarea className="title" onChange={() => settitle(event.target.value)}/>
      <button type="submit" onClick={handleClick}>Submit</button>
    </>
  );
}
