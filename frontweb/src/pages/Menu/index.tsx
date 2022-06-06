import ProductCard from 'components/ProductCard';
import { Link } from 'react-router-dom';
import { Product } from 'types/product';

import './styles.css';

const Menu = () => {
  const product: Product = {
    id: 1,
    name: 'Hamburger',
    description: 'Hamburger de siri',
    price: 35.0,
    imgUri:
      'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg',
  };

  return (
    <div className="container my-4 menu-container">
      <div className="row menu-title-container">
        <h1>Menu de Produtos</h1>
      </div>
      <div className="row">
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/products/1">
            <ProductCard product={product} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/products/1">
            <ProductCard product={product} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/products/1">
            <ProductCard product={product} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/products/1">
            <ProductCard product={product} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/products/1">
            <ProductCard product={product} />
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Menu;
