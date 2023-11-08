import React from 'react'
import ReactDOM from 'react-dom/client'
import { BrowserRouter, Route, Routes } from "react-router-dom";

import './style.css'
import Home from './views/home/home'
import NotFound from './views/not-found/not-found'

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route element={<Home/>} path="/" />
        <Route element={<NotFound/>} path="*" />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);
