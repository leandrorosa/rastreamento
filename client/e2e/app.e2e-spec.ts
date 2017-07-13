import { RastreamentoPage } from './app.po';

describe('rastreamento App', () => {
  let page: RastreamentoPage;

  beforeEach(() => {
    page = new RastreamentoPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
