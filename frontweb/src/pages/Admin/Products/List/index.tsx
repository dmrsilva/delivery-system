import ProductCrudCard from 'pages/Admin/Products/ProductCrudCard';
import { Link } from 'react-router-dom';

import './styles.css';

const List = () => {
  const product = {
    id: 1,
    name: 'Hamburger',
    description: 'Hamburger de siri',
    price: 35.0,
    imgUri:
      'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg',
  };

  return (
    <div className="product-crud-container">
      <div className="product-crud-bar-container">
        <Link to="/admin/products/create">
          <button className="btn btn-primary text-white btn-crud-add">
            ADICIONAR
          </button>
        </Link>
        <div className="base-card product-filter-container">Search bar</div>
      </div>
      <div className="row">
        <div className="col-sm-6 col-md-12">
          <ProductCrudCard product={product} />
        </div>
        <div className="col-sm-6 col-md-12">
          <ProductCrudCard product={product} />
        </div>
        <div className="col-sm-6 col-md-12">
          <ProductCrudCard product={product} />
        </div>
      </div>
    </div>
  );
};

export default List;
