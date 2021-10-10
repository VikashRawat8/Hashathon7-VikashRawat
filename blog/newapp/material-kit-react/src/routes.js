import { Navigate } from 'react-router-dom';
import DashboardLayout from './components/DashboardLayout';
import MainLayout from './components/MainLayout';
import Account from './pages/Account';
import HasherList from './pages/HasherList';
import Dashboard from './pages/Dashboard';
import MyBlogList from './pages/MyBlogList';
import Settings from './pages/Settings';
import Editor from './components/editor/editor';
import ShowBlog from './components/editor/ShowBlog';

const routes = [
  {
    path: 'app',
    element: <DashboardLayout />,
    children: [
      { path: 'account', element: <Account /> },
      { path: 'Hashers', element: <HasherList /> },
      { path: 'dashboard', element: <Dashboard /> },
      { path: 'MyBlogs', element: <MyBlogList /> },
      { path: 'settings', element: <Settings /> },
      { path: 'Editor', element: <Editor /> },
      { path: 'dashboard/singleblog', element: <ShowBlog /> },
      { path: '*', element: <Navigate to="/404" /> }
    ]
  },
  {
    path: '/',
    element: <MainLayout />,
    children: [
      { path: '/', element: <Navigate to="/app/dashboard" /> },
      { path: '*', element: <Navigate to="/404" /> }
    ]
  }
];

export default routes;
