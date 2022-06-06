import { ReactComponent as ArrowIcon } from 'assets/images/arrow.svg';

import './styles.css';

const ButtonIcon = () => {
  return (
    <div className="btn-container">
      <button className="btn btn-primary">
        <h6>Ir para página de pedidos</h6>
      </button>
      <div className="btn-icon-container">
        <ArrowIcon />
      </div>
    </div>
  );
};

export default ButtonIcon;
