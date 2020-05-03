module.exports = {
  first: {
    Docusaurus: ['doc1', 'doc2', 'doc3', {
      type: 'ref',
      id: 'nested/doc4'
    }, {
        type: 'link',
        label: 'Hello World',
      href: 'https://google.com'
    }],
    Features: ['mdx'],
  },
  second: {
    'NewTrial': []
  }
};
