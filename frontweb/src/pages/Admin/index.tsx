import PrivateRoute from 'components/PrivateRoute';
import { Switch } from 'react-router-dom';
import Navbar from './Navbar';
import Users from './Users';
import Products from './Products';

import './styles.css';

const Admin = () => {
  return (
    <div className="admin-container">
      <Navbar />
      <div className="admin-content">
        <Switch>
          <PrivateRoute path="/admin/products">
            <Products />
          </PrivateRoute>
          <PrivateRoute path="/admin/orders">
            <h1>Em desenvolvimento</h1>
          </PrivateRoute>
          <PrivateRoute path="/admin/users" roles={['ROLE_ADMIN']}>
            <h1>Em desenvolvimento</h1><br></br>
            <Users />
          </PrivateRoute>
        </Switch>
      </div>
    </div>
  );
};

export default Admin;
